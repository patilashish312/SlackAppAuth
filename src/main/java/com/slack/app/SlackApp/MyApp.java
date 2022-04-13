package com.slack.app.SlackApp;

import java.io.IOException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.slack.api.bolt.App;
import com.slack.api.bolt.socket_mode.SocketModeApp;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class MyApp {
	public static void main(String[] args) throws IOException, Exception {
		var app = new App();
		app.command("/testcommand", (req, ctx) -> {
			var logger = ctx.logger;
			try {
				var result = ctx.client().chatPostMessage(
						r -> r.token(ctx.getBotToken()).channel(ctx.getChannelId()).text(":wave: Hello"));
			} catch (Exception e) {
				logger.error("error: {}", e.getMessage(), e);
			}
			return ctx.ack();
		});
		new SocketModeApp(app).start();
	}
}
