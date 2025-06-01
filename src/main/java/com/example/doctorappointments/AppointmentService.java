package com.example.doctorappointments;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AppointmentService {
    private final Map<Long, Appointment> appointments = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    public List<Appointment> findAll() {
        return new ArrayList<>(appointments.values());
    }

    public Appointment findById(Long id) {
        return appointments.get(id);
    }

    public void save(Appointment appointment) {
        if (appointment.getId() == null) {
            appointment.setId(idCounter.incrementAndGet());
        }
        appointments.put(appointment.getId(), appointment);
    }

    public void delete(Long id) {
        appointments.remove(id);
    }
}
