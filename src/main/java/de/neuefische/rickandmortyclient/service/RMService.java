package de.neuefische.rickandmortyclient.service;

import de.neuefische.rickandmortyclient.model.RMCharacter;
import de.neuefische.rickandmortyclient.model.RMCharacterCollection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@Service
public class RMService {

    private final WebClient webClient; // = WebClient.create("https://rickandmortyapi.com/api/"); // initialize webclient with standard uri which will be called from every method

    public RMService(@Value("${rick-and-morty-api-url}") String rmApiUrl){
        this.webClient = WebClient.create(rmApiUrl);
    }

    public List<RMCharacter> getAllCharacters() {
        RMCharacterCollection response =
                Objects.requireNonNull(webClient.get()
                                .uri("/character") // Spezifizierung der Uri auf genaue Adresse
                                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) // JSON als Content festlegen
                                .retrieve() // hole mir die Daten!
                                .toEntity(RMCharacterCollection.class) // Mappe sie bitte auf folgende Klasse
                                .block()) // Warte bis alles andere fertig ist
                        .getBody(); // Gib mir den Körper der Antwort in welchem die Daten vorhanden sind
        return response.getResults(); // return only the results from the rmcharactercollection
    }

    public List<RMCharacter> getAllAliveCharacters() {
        RMCharacterCollection response =
                Objects.requireNonNull(webClient.get()
                                .uri("/character/?status=alive")
                                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .retrieve()
                                .toEntity(RMCharacterCollection.class)
                                .block())
                        .getBody();
        return response.getResults();
    }
}
