package com.github.rafaelrosagithub.agendaapi.model.repository;

import com.github.rafaelrosagithub.agendaapi.model.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
