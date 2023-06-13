package com.example.moyiza_be.event.controller;

import com.example.moyiza_be.common.security.userDetails.UserDetailsImpl;
import com.example.moyiza_be.event.dto.EventRequestDto;
import com.example.moyiza_be.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/club")
public class EventController {
    private final EventService eventService;

    // create
    @PostMapping(value = "/{club_id}/event", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> createEvent(@RequestPart(value = "data")  EventRequestDto eventRequestDto, @RequestPart(value = "image")MultipartFile image, @PathVariable Long club_id, @AuthenticationPrincipal UserDetailsImpl userDetails) throws IOException {
        return eventService.createEvent(eventRequestDto, userDetails.getUser(), club_id, image);
    }

    // ReadAll
    // NO url : Process in Club

    // ReadOne
    @GetMapping("/{club_id}/event/{event_id}")
    public ResponseEntity<?> getEvent(@PathVariable Long club_id, @PathVariable Long event_id) {
        return eventService.getEvent(club_id,event_id);
    }

    // Update : Hold
//    @PutMapping("/{club_id}/event/{event_id}")
//    public String putEvent() {
//    }

    // Delete
    @DeleteMapping("/{club_id}/event/{event_id}")
    public ResponseEntity<?> deleteEvent(@PathVariable long club_id, @PathVariable long event_id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return eventService.deleteEvent(club_id,event_id, userDetails.getUser());
    }

//     Attend
    @PostMapping("/{club_id}/event/join/{event_id}")
    public ResponseEntity<?> joinEvent(@PathVariable(name = "club_id") Long clubId, @PathVariable(name = "event_id") Long eventId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return eventService.joinEvent(eventId, userDetails.getUser());
    }

    // Cancel Attend
    @DeleteMapping("/{club_id}/event/join/{event_id}")
    public ResponseEntity<?> attendEvent(@PathVariable long club_id, @PathVariable long event_id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return eventService.cancelEvent(event_id, userDetails.getUser());
    }
}
