package com.github.rafaelrosagithub.agendaapi.model.api.rest;

import com.github.rafaelrosagithub.agendaapi.model.entity.Contact;
import com.github.rafaelrosagithub.agendaapi.model.repository.ContactRepository;
import jakarta.servlet.http.Part;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
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

    @PatchMapping("{id}/favorite")
    public void favorite(@PathVariable Integer id) {
        Optional<Contact> contact = contactRepository.findById(id);
        contact.ifPresent(c -> {
            boolean favorite = c.getFavorite() == Boolean.TRUE;
            c.setFavorite(!favorite);
            contactRepository.save(c);
        });
    }

    @PutMapping("{id}/photo")
    public byte[] addPhoto(@PathVariable Integer id, @RequestParam("photo") Part file) {
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.map(c -> {
           try {
               InputStream inputStream = file.getInputStream();
               byte[] bytes = new byte[(int) file.getSize()];
               IOUtils.readFully(inputStream, bytes);
               c.setPhoto(bytes);
               contactRepository.save(c);
               inputStream.close();
               return bytes;
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
        }).orElse(null);
    }
}
