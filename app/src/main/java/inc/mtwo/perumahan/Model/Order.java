package inc.mtwo.perumahan.Model;

import com.google.gson.annotations.SerializedName;

public class Order {

    @SerializedName("iduser") private String Iduser;
    @SerializedName("blok") private String Blok;
    @SerializedName("harga") private String Harga;

    public String getIduser() {
        return Iduser;
    }

    public String getBlok() {
        return Blok;
    }

    public String getHarga() {
        return Harga;
    }
}
