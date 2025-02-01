package ru.levelup.lesson12.clients;

public class CorparateClient extends AbstractClient {
    private String ogrn;

    public CorparateClient() {
        super(null, null);
    }

    public CorparateClient(String fullName, String inn, String ogrn) {
        super(fullName, inn);
        this.ogrn = ogrn;
    }

    public String getOgrn() {
        return ogrn;
    }

    @Override
    public String toString() {
        return "CorparateClient{" +
                "ogrn='" + ogrn + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", inn='" + getInn() + '\'' +
                '}';
    }
}
