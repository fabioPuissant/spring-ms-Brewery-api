package com.fabio.Brewery.web.controller.v2;

import com.fabio.Brewery.services.BeerService;
import com.fabio.Brewery.services.v2.BeerServiceV2;
import com.fabio.Brewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {
    private final BeerServiceV2 beerService;

    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    /**
     * Endpoint for the beer api that creates a new beer object
     * @param beerDto the New beer object to be added
     * @return HTTP-response status: 201-CREATED with the location of the newly created Beer object
     */
    @PostMapping // POST - create new beer
    public ResponseEntity handlePost(@RequestBody  BeerDtoV2 beerDto){
        BeerDtoV2 saveDto = beerService.saveNewBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + saveDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId,
                                       @RequestBody BeerDtoV2 beerDto){
        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable UUID beerId){
        beerService.deleteBeer(beerId);
    }
}

