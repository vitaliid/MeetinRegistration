package com.sdarm.meetingregistration.facade;

import com.sdarm.meetingregistration.dto.apartment.ApartmentResponse;
import com.sdarm.meetingregistration.dto.bed.BedResponse;
import com.sdarm.meetingregistration.mapper.ApartmentMapper;
import com.sdarm.meetingregistration.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApartmentFacade {

    private final ApartmentService apartmentService;
    private final ApartmentMapper apartmentMapper;

    public List<ApartmentResponse> getAll(boolean isAvailableOnly) {
        return apartmentService.getAll().stream()
                .map(apartmentMapper::toDto)
                .sorted(Comparator.comparing(ApartmentResponse::getNumber))
                .map(apartmentResponse -> {
                    apartmentResponse.setBeds(apartmentResponse.getBeds().stream()
                            .sorted(Comparator.comparing(BedResponse::getNumber))
                            .collect(Collectors.toList()));
                    return apartmentResponse;
                })
                .filter(apartmentResponse -> {

                    if (isAvailableOnly) {
                        List<BedResponse> notAvailableBeds = apartmentResponse.getBeds().stream()
                                .filter(bedResponse -> bedResponse.getParticipant() != null)
                                .collect(Collectors.toList());
                        apartmentResponse.getBeds().removeAll(notAvailableBeds);
                        return !apartmentResponse.getBeds().isEmpty();
                    } else return true;
                })
                .collect(Collectors.toList());
    }
}
