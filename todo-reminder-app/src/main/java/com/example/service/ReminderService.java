package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ReminderService {
    private List<Timer> timers;

    public ReminderService() {
        timers = new ArrayList<>();
    }

    public void scheduleReminder(long delay, Runnable task) {
        Timer timer = new Timer();
        timers.add(timer);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                task.run();
                timers.remove(timer);
            }
        }, delay);
    }

    public void cancelReminder(Timer timer) {
        if (timers.contains(timer)) {
            timer.cancel();
            timers.remove(timer);
        }
    }

    public void cancelAllReminders() {
        for (Timer timer : timers) {
            timer.cancel();
        }
        timers.clear();
    }
}