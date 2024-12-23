package com.wane.web.mapper;

import com.wane.web.dto.request.CreateApprenantRequest;
import com.wane.web.dto.response.ApprenantResponse;
import com.wane.data.entities.Apprenent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ApprenantMapper {

    @Mapping(source = "promotionReferentielId", target = "promotionReferentiel.id")
    @Mapping(source = "userId", target = "user.id")
    Apprenent toEntity(CreateApprenantRequest dto);

    ApprenantResponse toResponse(Apprenent entity);
}