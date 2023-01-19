package edu.kss.http_requests;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping(value="/get")
    public ResponseEntity<String> serveGetRequest(){

        System.out.println("GET-Request eingetroffen");

        //TODO: Serverreaktion programmieren:
        String answer = "Standardantwort GET";


        return ResponseEntity.status(HttpStatus.OK).body(answer);
    }

    @PostMapping(value="/post")
    public ResponseEntity<String> servePostRequest(@RequestBody String body){

        System.out.println("POST-Request eingetroffen");
        String answer;

        try {
            JSONObject jsonObject = new JSONObject(body);
            answer = "Standardantwort POST";

            //TODO: Serverreaktion programmieren:
            String name = jsonObject.getString("name"); //Beispielkey (kann ersetzt werden)
            int alter = jsonObject.getInt("alter"); //Beispielkey (kann ersetzt werden)

        }
        catch (Exception e){
            String warningMessage = "Ungültige Anfrage";
            System.out.println(warningMessage);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(warningMessage);
        }

        System.out.println("Gegebene Antwort: " + answer);
        return ResponseEntity.status(HttpStatus.OK).body(answer);
    }


}

