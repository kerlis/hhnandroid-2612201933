package me.doapps.appdhn.activities;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import me.doapps.appdhn.R;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import static android.content.ContentValues.TAG;

public class FirebaseInstanceIDService extends FirebaseInstanceIdService {
    String elvalor = "a";
    String elvalor2 = "bb";
    String valorcero = "0";
    String orden;
    String Message;
    String ko,ajustes,tipo;
    Integer r,s;
    String json;
    String datou = "valueu";

    @Override
    public void onTokenRefresh() {
        String token = FirebaseInstanceId.getInstance().getToken();
        registerToken(token);
        ver();
        contador();
        createNotificationChannel();
        valoresconfiguracion();
    }

    private void createNotificationChannel() {
        Log.d("service", "processing grabando");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Uri defaultSoundUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.beep2);
            AudioAttributes att = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                    .build();


            CharSequence name = getString(R.string.default_notification_channel_name_sismos);
            String channelId = getString(R.string.default_notification_channel_id_sismos);
            String description = getString(R.string.channel_description_sismos);

            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(channelId, name, importance);
            channel.setDescription(description);
            channel.setSound(defaultSoundUri, att);
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            channel.enableVibration(true);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void registerToken(String token) {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("Token",token)
                .build();
        Request request = new Request.Builder()
                //.url("http://arteypixel.com/envio_notificaciones/register.php?Token="+token)
                .url("http://intranet.igp.gob.pe/AnMI0laYWBo4/index.php?Token="+token)

                .post(body)
                .build();


        // consulta("http://arteypixel.com/envio_notificaciones/register.php?Token="+token);
        consulta("http://intranet.igp.gob.pe/AnMI0laYWBo4/index.php?Token="+token);

        guardartoken(token);

        try {
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void consulta(String urlString)  {
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = null;
            BufferedReader bufferedReader = null;
            urlConnection = (HttpURLConnection) url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            json = bufferedReader.readLine();
            //  Toast.makeText(getApplicationContext(), json, Toast.LENGTH_SHORT).show();
            Log.d(TAG, "fdfdfd json: " + json);
            //();
            ver2(json);
            urlConnection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ver2(String dato) {
        String Message5 = dato;
        String file_namex = "datos_ordences";
        try {
            FileOutputStream fileOutputStream = openFileOutput(file_namex, MODE_PRIVATE);
            fileOutputStream.write(Message5.getBytes());
            FirebaseMessaging.getInstance().subscribeToTopic("PRUEBAXT2019");
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardartoken(String token) {
        String Message5 = token;
        String file_namex = "eltoken";
        try {
            FileOutputStream fileOutputStream = openFileOutput(file_namex, MODE_PRIVATE);
            fileOutputStream.write(Message5.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ver() {
        String Message3 = elvalor + ",";
        String Message4 = elvalor2 + ",";
        String file_name = "datos_configuracion";
        try {
            FileOutputStream fileOutputStream = openFileOutput(file_name, MODE_PRIVATE);
            fileOutputStream.write(Message3.getBytes());
            fileOutputStream.write(Message4.getBytes());
            fileOutputStream.close();
            //  Toast.makeText(getApplicationContext(), "Configurado", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void contador() {
        String Message3 = valorcero;
        String file_name = "valorcero";
        try {
            FileOutputStream fileOutputStream = openFileOutput(file_name, MODE_PRIVATE);
            fileOutputStream.write(Message3.getBytes());
            fileOutputStream.close();
            //  Toast.makeText(getApplicationContext(), "Configurado", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void valoresconfiguracion() {

        String file_ramdom = "ramdom_number_file";
        String file_vibrar = "vibrar_file";
        String file_sonido = "sonido_file";
        String file_notificar = "notificar_file";
        String file_tipo = "tipo_file";
        String file_ringtone = "ring_tone_file";
        String file_nombre_ringtone = "nombre_ringtone__file";
        String vibrar_val =  "11111";
        String sonido_val =  "A";
        String notificacion_val =  "11111";
        String ringtone_val =  "A";
        String tiposonidoval =  "11111";
        String nombre_ringtone_val =  "A";

        try {

            FileOutputStream fileOutputStream_ramdom = openFileOutput(file_ramdom, MODE_PRIVATE);
            fileOutputStream_ramdom.write(vibrar_val.getBytes());

            FileOutputStream fileOutputStream_vibrar = openFileOutput(file_vibrar, MODE_PRIVATE);
            fileOutputStream_vibrar.write(vibrar_val.getBytes());

            FileOutputStream fileOutputStream_sonido = openFileOutput(file_sonido, MODE_PRIVATE);
            fileOutputStream_sonido.write(sonido_val.getBytes());

            FileOutputStream fileOutputStream_notificar = openFileOutput(file_notificar, MODE_PRIVATE);
            fileOutputStream_notificar.write(notificacion_val.getBytes());

            FileOutputStream fileOutputStream_sonidotipo = openFileOutput(file_tipo, MODE_PRIVATE);
            fileOutputStream_sonidotipo.write(tiposonidoval.getBytes());

            FileOutputStream fileOutputStream_ring_tone = openFileOutput(file_ringtone, MODE_PRIVATE);
            fileOutputStream_ring_tone.write(ringtone_val.getBytes());

            FileOutputStream fileOutputStream_nombre_ring_tone = openFileOutput(file_nombre_ringtone, MODE_PRIVATE);
            fileOutputStream_nombre_ring_tone.write(nombre_ringtone_val.getBytes());

            fileOutputStream_nombre_ring_tone.close();

            fileOutputStream_ring_tone.close();

            fileOutputStream_sonidotipo.close();

            fileOutputStream_notificar.close();

            fileOutputStream_vibrar.close();

            fileOutputStream_sonido.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}