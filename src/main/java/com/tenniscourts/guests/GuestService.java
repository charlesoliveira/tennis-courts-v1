package com.tenniscourts.guests;

import com.tenniscourts.exceptions.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GuestService {

    @Autowired
    private final GuestRepository guestRepository;

    @Autowired
    private final GuestMapper guestMapper;

    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    public GuestDTO findById(Long id) {
        return guestRepository.findById(id).map(guestMapper::map).orElseThrow(() ->{
            throw new EntityNotFoundException("Guest not found.");
        });
    }

    public List<Guest> findByName(String name) {
        return guestRepository.findByNameContains(name);
    }

    public Guest insert(Guest guest) {
        return guestRepository.save(guest);
    }

    public Guest edit(Long id, Guest guest) {

        Guest record = guestRepository.getOne(id);
        updateData(record, guest);
        return guestRepository.save(record);
    }

    private void updateData(Guest record, Guest guest) {
        record.setName(guest.getName());
    }

    public void delete(Long id) {
        guestRepository.deleteById(id);
    }

}
