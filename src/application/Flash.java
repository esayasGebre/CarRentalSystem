package application;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Flash {
	public void runTask() {

		final double wndwWidth = 300.0d;
		Label updateLabel = new Label("Running tasks...");
		updateLabel.setPrefWidth(wndwWidth);
		ProgressBar progress = new ProgressBar();
		progress.setPrefWidth(wndwWidth);

		VBox updatePane = new VBox();
		updatePane.setPadding(new Insets(10));
		updatePane.setSpacing(5.0d);
		updatePane.getChildren().addAll(updateLabel, progress);

		Stage taskUpdateStage = new Stage(StageStyle.UTILITY);
		taskUpdateStage.setScene(new Scene(updatePane));
		taskUpdateStage.show();

		Task longTask = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				int max = 100;
				for (int i = 1; i <= max; i++) {
					if (isCancelled()) {
						break;
					}
					updateProgress(i, max);
					updateMessage("Task part " + String.valueOf(i) + " complete");

					Thread.sleep(30);
				}
				return null;
			}
		};

		longTask.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent t) {
				taskUpdateStage.hide();
			}
		});
		progress.progressProperty().bind(longTask.progressProperty());
		updateLabel.textProperty().bind(longTask.messageProperty());

		taskUpdateStage.show();
		new Thread(longTask).start();
	}
}
