package id.co.firzil.myalarm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.co.firzil.myalarm.database.Database;

/**
 * Created by alpin on 21/09/17.
 */

public class AlarmListAdapter extends BaseAdapter {

    private MainActivity alarmActivity;
    private List<Alarm> alarms = new ArrayList<Alarm>();

    public static final String ALARM_FIELDS[] = { Database.COLUMN_ALARM_ACTIVE,
            Database.COLUMN_ALARM_TIME, Database.COLUMN_ALARM_DAYS };

    public AlarmListAdapter(MainActivity alarmActivity) {
        this.alarmActivity = alarmActivity;
//		Database.init(alarmActivity);
//		alarms = Database.getAll();
    }

    @Override
    public int getCount() {
        return alarms.size();
    }

    @Override
    public Object getItem(int i) {
        return alarms.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (null == view)
            view = LayoutInflater.from(alarmActivity).inflate(
                    R.layout.item_list, null);

        Alarm alarm = (Alarm) getItem(i);

        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkBox_alarm_active);
        checkBox.setChecked(alarm.getAlarmActive());
        checkBox.setTag(i);
        checkBox.setOnClickListener((View.OnClickListener) alarmActivity);

        TextView alarmTimeView = (TextView) view
                .findViewById(R.id.textView_alarm_time);
        alarmTimeView.setText(alarm.getAlarmTimeString());


        TextView alarmDaysView = (TextView) view
                .findViewById(R.id.textView_alarm_days);
        alarmDaysView.setText(alarm.getRepeatDaysString());


        return view;
    }

    public void setMathAlarms(List<Alarm> alarms) {
        this.alarms = alarms;
    }
}
