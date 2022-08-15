package com.example.config;

import org.mapstruct.NullValuePropertyMappingStrategy;

@org.mapstruct.MapperConfig(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MapperConfig {
}
