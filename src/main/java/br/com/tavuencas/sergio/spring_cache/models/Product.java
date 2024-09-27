package br.com.tavuencas.sergio.spring_cache.models;

import java.io.Serializable;


public record Product(Long id, String name, String description) implements Serializable {
}
