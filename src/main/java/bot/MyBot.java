package bot;

import bot.controller.UserController;
import bot.entity.City;
import bot.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyBot extends TelegramLongPollingBot {
    private static final String TOKEN = "1079072516:AAEnPU2XCt33JyvCVb1rAlbyvUSmzRPWmfo";
    private static final String BOTUSERNAME = "InfoCitiesBot";

    public String getBotToken() {
        return TOKEN;
    }

    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        sendMsg(update.getMessage().getChatId().toString(), message);
    }

    public String getBotUsername() {
        return BOTUSERNAME;
    }

    public synchronized void sendMsg(String chatId, String s) {
        try {
            String url = "http://localhost:8080/city/";
            URL obj = new URL(url + s);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            SendMessage sendMessage = new SendMessage();
            sendMessage.enableMarkdown(true);
            sendMessage.setChatId(chatId);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String ans=in.readLine();
            if (ans!=null) {
                sendMessage.setText(ans);
            }else{
                sendMessage.setText("Check entered information");
            }
            execute(sendMessage);
        } catch (TelegramApiException | IOException e) {
            e.printStackTrace();
        }
    }
}
