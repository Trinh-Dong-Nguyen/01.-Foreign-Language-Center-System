package com.prj.projectweb.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseRequest {
    String courseName;
    List<CourseContentRequest> courseContent;
    String objective;
    String duration;
    String tuitionFee;
    String learningMethod;
    CertificateRequest certificate;
    String startTime;
    String endTime;
    Set<Long> schedule;
    Integer likes;
    String image;
    Integer numberOfStudents;
    String object;
    String room;
    Long centerId;

    GiangVienRequest giangVien;
}
