package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для класса ProjectTask.
 */
class ProjectTaskTest {

    @Test
    void testCreateValidTask() {
        ProjectTask task = new ProjectTask("TASK-001", "Implement feature", TaskStatus.TODO, 8);
        assertEquals("TASK-001", task.getId());
        assertEquals("Implement feature", task.getTitle());
        assertEquals(TaskStatus.TODO, task.getStatus());
        assertEquals(8, task.getEstimatedHours());
    }

    @Test
    void testNullId() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask(null, "Title", TaskStatus.TODO, 5));
    }

    @Test
    void testEmptyId() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask("", "Title", TaskStatus.TODO, 5));
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask("   ", "Title", TaskStatus.TODO, 5));
    }

    @Test
    void testNullTitle() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask("ID-001", null, TaskStatus.TODO, 5));
    }

    @Test
    void testEmptyTitle() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask("ID-001", "", TaskStatus.TODO, 5));
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask("ID-001", "   ", TaskStatus.TODO, 5));
    }

    @Test
    void testNullStatus() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask("ID-001", "Title", null, 5));
    }

    @Test
    void testNegativeEstimatedHours() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask("ID-001", "Title", TaskStatus.TODO, -1));
    }

    @Test
    void testZeroEstimatedHours() {
        ProjectTask task = new ProjectTask("ID-001", "Quick fix", TaskStatus.TODO, 0);
        assertEquals(0, task.getEstimatedHours());
    }

    @Test
    void testChangeStatus() {
        ProjectTask task = new ProjectTask("TASK-001", "Feature", TaskStatus.TODO, 8);
        task.changeStatus(TaskStatus.IN_PROGRESS);
        assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
        task.changeStatus(TaskStatus.DONE);
        assertEquals(TaskStatus.DONE, task.getStatus());
    }

    @Test
    void testChangeStatusToNull() {
        ProjectTask task = new ProjectTask("TASK-001", "Feature", TaskStatus.TODO, 8);
        assertThrows(IllegalArgumentException.class, () -> task.changeStatus(null));
    }

    @Test
    void testIsCompletedWhenDone() {
        ProjectTask task = new ProjectTask("TASK-001", "Feature", TaskStatus.DONE, 8);
        assertTrue(task.isCompleted());
    }

    @Test
    void testIsCompletedWhenNotDone() {
        ProjectTask task = new ProjectTask("TASK-001", "Feature", TaskStatus.TODO, 8);
        assertFalse(task.isCompleted());

        task.changeStatus(TaskStatus.IN_PROGRESS);
        assertFalse(task.isCompleted());
    }

    @Test
    void testIncreaseEstimate() {
        ProjectTask task = new ProjectTask("TASK-001", "Feature", TaskStatus.TODO, 8);
        task.increaseEstimate(4);
        assertEquals(12, task.getEstimatedHours());
        task.increaseEstimate(2);
        assertEquals(14, task.getEstimatedHours());
    }

    @Test
    void testIncreaseEstimateWithNonPositive() {
        ProjectTask task = new ProjectTask("TASK-001", "Feature", TaskStatus.TODO, 8);
        assertThrows(IllegalArgumentException.class, () -> task.increaseEstimate(0));
        assertThrows(IllegalArgumentException.class, () -> task.increaseEstimate(-5));
    }

    @Test
    void testTaskWorkflow() {
        ProjectTask task = new ProjectTask("TASK-001", "Implement login", TaskStatus.TODO, 5);
        assertFalse(task.isCompleted());

        task.changeStatus(TaskStatus.IN_PROGRESS);
        task.increaseEstimate(3);
        assertEquals(8, task.getEstimatedHours());
        assertFalse(task.isCompleted());

        task.changeStatus(TaskStatus.DONE);
        assertTrue(task.isCompleted());
    }
}
