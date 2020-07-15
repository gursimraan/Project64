package com.example.project64

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.subject_card.view.*

class SubjectBaseAdapter(
    private var context: Context,
    private var subjectList: MutableList<Subject>,
    private var dayOrTime: String
) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var localView = convertView
        val viewHolder: SubjectViewHolder

        if (localView == null) {
            val inflater = LayoutInflater.from(context)
            localView = inflater.inflate(R.layout.subject_card, parent, false)

            viewHolder = SubjectViewHolder(view = localView)
            localView.tag = viewHolder
        } else {
            viewHolder = localView.tag as SubjectViewHolder
        }

        viewHolder.nameLabel.text = subjectList[position].name
        viewHolder.attendanceLabel.text = subjectList[position].attendance.toString()
        viewHolder.notificationsLabel.text = subjectList[position].notifications.toString()
        viewHolder.timeLabel.text = subjectList[position].startTime
        viewHolder.dayLabel.text = subjectList[position].days.joinToString("  ")


        if (dayOrTime == "day") {
            viewHolder.timeLabel.visibility = View.INVISIBLE
            viewHolder.dayLabel.visibility = View.VISIBLE
        } else {
            viewHolder.timeLabel.visibility = View.VISIBLE
            viewHolder.dayLabel.visibility = View.INVISIBLE
        }

        return localView
    }

    override fun getItem(position: Int): Any {
        return subjectList[position]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return subjectList.size
    }
}

class SubjectViewHolder(view: View) {
    var nameLabel: TextView = view.nameLabel
    var attendanceLabel: TextView = view.attendanceLabel
    var notificationsLabel: TextView = view.notificationsLabel
    var timeLabel: TextView = view.timeLabel
    var dayLabel: TextView = view.dayLabel
}