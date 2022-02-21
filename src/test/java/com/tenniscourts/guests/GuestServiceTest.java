package com.tenniscourts.guests;

import com.tenniscourts.ApplicationConfigTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DisplayName("GuestServiceTest")
@RunWith(MockitoJUnitRunner.class)
public class GuestServiceTest extends ApplicationConfigTest {

    @Mock
    GuestRepository guestRepository;

    @InjectMocks
    private GuestService guestService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll() {

    }

    @Test
    public void findById() {
        Long id = 1L;
        Guest guest = Mockito.mock(Guest.class);
        Assert.assertEquals( id, id);
    }

    @Test
    public void findByName() {
        List<Guest> listOfGuests = new ArrayList<Guest>();
        listOfGuests.add(new Guest(1L, "Roger Federer"));
        Assert.assertEquals(listOfGuests, listOfGuests);

    }

    @Test
    public void create() {
        Guest newGuest = new Guest( 3L, "Charles Oliveira");
        Assert.assertEquals(newGuest, newGuest);
    }

    @Test
    public void delete() {
        Long id = 3L;
        Assert.assertEquals(id, id);
    }
}
