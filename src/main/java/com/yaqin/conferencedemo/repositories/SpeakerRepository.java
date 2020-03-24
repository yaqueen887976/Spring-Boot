package com.yaqin.conferencedemo.repositories;

import com.yaqin.conferencedemo.models.Session;
import com.yaqin.conferencedemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
