package gmibank.com.pojos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Accounts {
    public Accounts(String unknown) {
        this.unknown = unknown;
    }

    public Accounts() {
    }

    private String unknown;

    public String getUnknown() {
        return unknown;
    }

    public void setUnknown(String unknown) {
        this.unknown = unknown;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "unknown='" + unknown + '\'' +
                '}';
    }


}
