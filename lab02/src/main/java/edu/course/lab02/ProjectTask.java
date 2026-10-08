package edu.course.lab02;

public class ProjectTask {

    private final String id;
    private final String title;
    private TaskStatus status;
    private int estimatedHours;

    /**
     * Создает новую задачу проекта.
     *
     * @param id идентификатор задачи
     * @param title название задачи
     * @param status начальный статус задачи
     * @param estimatedHours оценка трудоемкости в часах
     * @throws IllegalArgumentException если любой из параметров нарушает инварианты
     */
    public ProjectTask(String id, String title, TaskStatus status, int estimatedHours) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Идентификатор не может быть null или пустым");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Название не может быть null или пустым");
        }
        if (status == null) {
            throw new IllegalArgumentException("Статус не может быть null");
        }
        if (estimatedHours < 0) {
            throw new IllegalArgumentException("Оценка трудоемкости не может быть отрицательной");
        }

        this.id = id;
        this.title = title;
        this.status = status;
        this.estimatedHours = estimatedHours;
    }

    /**
     * Изменяет статус задачи.
     *
     * @param newStatus новый статус
     * @throws IllegalArgumentException если новый статус null
     */
    public void changeStatus(TaskStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("Статус не может быть null");
        }
        this.status = newStatus;
    }

    /**
     * Проверяет, завершена ли задача.
     *
     * @return true, если задача имеет статус DONE
     */
    public boolean isCompleted() {
        return status == TaskStatus.DONE;
    }

    /**
     * Увеличивает оценку трудоемкости на указанное количество часов.
     *
     * @param additionalHours количество часов для добавления
     * @throws IllegalArgumentException если количество часов не положительное
     */
    public void increaseEstimate(int additionalHours) {
        if (additionalHours <= 0) {
            throw new IllegalArgumentException("Количество добавляемых часов должно быть положительным");
        }
        this.estimatedHours += additionalHours;
    }

    /**
     * Возвращает идентификатор задачи.
     *
     * @return идентификатор задачи
     */
    public String getId() {
        return id;
    }

    /**
     * Возвращает название задачи.
     *
     * @return название задачи
     */
    public String getTitle() {
        return title;
    }

    /**
     * Возвращает текущий статус задачи.
     *
     * @return текущий статус
     */
    public TaskStatus getStatus() {
        return status;
    }

    /**
     * Возвращает оценку трудоемкости в часах.
     *
     * @return оценка трудоемкости
     */
    public int getEstimatedHours() {
        return estimatedHours;
    }
}
