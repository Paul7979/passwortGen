package at.technikum.passwortGen;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PasswortGenService {

    @Async
    public CompletableFuture<List<String>> generatePasswords(Params params) {
        int amount = params.getAmount();
        List<String> passwords = new ArrayList<>(amount);
        char[] alphabet = params.getAlphabet();
        int length = params.getLength();
        for (int i = 0; i < amount; i++) {
            passwords.add(generatePassword(length, alphabet));
        }
        System.out.println("Generated " + params.getAmount() + " passwords with length: " + params.getLength());
        return CompletableFuture.completedFuture(passwords);
    }

    private String generatePassword(int length, char[] alphabet) {
        StringBuilder passwort = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int nextInt = ThreadLocalRandom.current().nextInt(alphabet.length - 1);
            passwort.append(alphabet[nextInt]);
        }
        return passwort.toString();
    }

}
