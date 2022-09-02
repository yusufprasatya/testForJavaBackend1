package com.testForJavaBackend1.testForJavaBackend1.repository;

import com.testForJavaBackend1.testForJavaBackend1.entity.Galery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FlickrRepository extends JpaRepository<Galery, UUID> {
}
