package inc.mtwo.perumahan.InterfaceApi;

import java.util.List;

import inc.mtwo.perumahan.Model.Order;
import inc.mtwo.perumahan.Model.Value;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RegisterApi {


    @GET("view.php")
    Call<Value> view();

    @GET("order.php")
    Call<List<Order>> order(@Query("iduser") String iduser );

}
