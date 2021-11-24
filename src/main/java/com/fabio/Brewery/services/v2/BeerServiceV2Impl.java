package com.fabio.Brewery.services.v2;

import com.fabio.Brewery.web.model.BeerDto;
import com.fabio.Brewery.web.model.v2.BeerDtoV2;
import com.fabio.Brewery.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder().id(beerId).beerName("Jupiler").beerStyle(BeerStyleEnum.STOUT).build();

    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .beerName(beerDto.getBeerName())
                .beerStyle(beerDto.getBeerStyle())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
        log.debug("Update a beerV2... ");

    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Delete a beerV2... ");
    }

}
