import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Chapter10 {
	public static void main(String[] args) throws Exception {
		List<Task> list = new ArrayList<>();
		list.add(new Task(LocalDate.of(2021, 10, 21), "牛乳を買う", true));
		list.add(new Task(LocalDate.of(2021, 9, 15), "○○社面接", false));
		list.add(new Task(LocalDate.of(2021, 12, 4), "手帳を買う", true));
		list.add(new Task(LocalDate.of(2021, 8, 10), "散髪に行く", false));
		list.add(new Task(LocalDate.of(2021, 11, 9), "スクールの課題を解く", false));

		// 以下記述
		List<Task> notDonelist = list.stream().filter(task -> !task.isDone()).sorted((t1, t2) -> t1.compareTo(t2))
				.collect(Collectors.toList());

		StringBuilder s = new StringBuilder();
		s.append("未完了のタスクの個数は").append(notDonelist.size()).append("\n").append("【未完了のタスクを昇順に並び替えて一覧表示】").append("\n");
		notDonelist.forEach(task -> s.append(task.toString()).append("\n"));
		System.out.println(s.toString());

	}
}