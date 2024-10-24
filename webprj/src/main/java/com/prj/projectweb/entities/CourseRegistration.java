package com.prj.projectweb.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.prj.projectweb.enumType.PaymentStatus;
import com.prj.projectweb.enumType.RegistrationStatus;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long registrationId;

    // Quan hệ với học viên đăng ký khóa học
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    User student;

    // Quan hệ với phụ huynh nếu có
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", nullable = true)
    User parent;

    // Quan hệ với khóa học
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    Course course;

    // Trạng thái đăng ký
    @Enumerated(EnumType.STRING)
    RegistrationStatus status;

    //Trạng thái đăng ký đã trả tiền cho môn học chưa
    @Column(name = "has_paid", nullable = false)
    @Builder.Default
    Boolean hasPaid = false;
    
    // Trạng thái thanh toán
    @Enumerated(EnumType.STRING)
    PaymentStatus paymentStatus;

    // Thời điểm thanh toán
    LocalDateTime paymentTime;

    // Setter cho paymentStatus
    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = (paymentStatus != null) ? paymentStatus : PaymentStatus.PENDING;
        if (paymentStatus == PaymentStatus.PAID) {
            this.paymentTime = LocalDateTime.now();
        }
    }

    // Optional: Phương thức để kiểm tra trạng thái thanh toán
    public PaymentStatus getPaymentStatus() {
        return (this.paymentStatus != null) ? this.paymentStatus : PaymentStatus.PENDING;
    }
    private Double paidAmount;
}

