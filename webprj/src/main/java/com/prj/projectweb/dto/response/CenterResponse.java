package com.prj.projectweb.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CenterResponse {
    Long id;
    String name;
    String address;
    String phone;
    String email;
    String managerName;
}
