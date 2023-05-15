package com.github.rafaelrosagithub.agendaapi.model.api.rest;

import com.github.rafaelrosagithub.agendaapi.model.entity.Contact;
import com.github.rafaelrosagithub.agendaapi.model.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contacts")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ContactController {

    private final ContactRepository contactRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contact save(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        contactRepository.deleteById(id);
    }

    @GetMapping
    public List<Contact> list() {
        return contactRepository.findAll();
    }

    @PatchMapping("{id}/favorite ")
    public void favorite(@PathVariable Integer id, @RequestBody Boolean favorite) {
        Optional<Contact> contact = contactRepository.findById(id);
        contact.ifPresent(c -> {
            c.setFavorite(favorite);
            contactRepository.save(c);
        });
    }
}
