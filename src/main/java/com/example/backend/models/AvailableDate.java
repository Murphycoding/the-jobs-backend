package com.example.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
@Getter
@Setter

@Entity
@Table(name = "available_date")
public class AvailableDate {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotNull
        private LocalDateTime start_at;
        @NotNull
        private LocalDateTime  end_at;
        @ManyToOne
        @JoinColumn(name = "consultant_id")
        private Consultant consultant;

        public AvailableDate(LocalDateTime  start_at, LocalDateTime  end_at, Consultant consultant) {
                this.start_at = start_at;
                this.end_at = end_at;
                this.consultant = consultant;
        }

        public AvailableDate() {

        }

//        @Override
//        public String toString() {
//                return "AvailableDate{" +
//                        "start=" + start_at +
//                        ", end=" + end_at +
//                        ", consultant=" + consultant +
//                        '}';
//        }
}
