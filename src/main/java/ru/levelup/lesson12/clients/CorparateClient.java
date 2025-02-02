package ru.levelup.lesson12.clients;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper=true)
public class CorparateClient extends AbstractClient {
    private String ogrn;

    public CorparateClient() {
        super(null, null);
    }

    public CorparateClient(String fullName, String inn, String ogrn) {
        super(fullName, inn);
        this.ogrn = ogrn;
    }

}
