package com.prj.projectweb.mapper;

import com.prj.projectweb.dto.request.TimeSlotRequest;
import com.prj.projectweb.entities.TimeSlot;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-15T22:53:13+0700",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.40.0.z20241023-1306, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class TimeSlotMapperImpl implements TimeSlotMapper {

    @Override
    public TimeSlot toTimeSlot(TimeSlotRequest request) {
        if ( request == null ) {
            return null;
        }

        TimeSlot.TimeSlotBuilder timeSlot = TimeSlot.builder();

        timeSlot.day( request.getDay() );
        timeSlot.timeRange( request.getTimeRange() );

        return timeSlot.build();
    }

    @Override
    public TimeSlotRequest toTimeSlotRequest(TimeSlot timeSlot) {
        if ( timeSlot == null ) {
            return null;
        }

        TimeSlotRequest.TimeSlotRequestBuilder timeSlotRequest = TimeSlotRequest.builder();

        timeSlotRequest.day( timeSlot.getDay() );
        timeSlotRequest.timeRange( timeSlot.getTimeRange() );

        return timeSlotRequest.build();
    }
}
