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
        val VIEW_HOLDER: SubjectViewHolder

        if (localView == null) {
            val INFLATER = LayoutInflater.from(context)
            localView = INFLATER.inflate(R.layout.subject_card, parent, false)

            VIEW_HOLDER = SubjectViewHolder(view = localView)
            localView.tag = VIEW_HOLDER
        } else {
            VIEW_HOLDER = localView.tag as SubjectViewHolder
        }

        VIEW_HOLDER.nameLabel.text = subjectList[position].name
        VIEW_HOLDER.attendanceLabel.text = subjectList[position].attendance.toString()
        VIEW_HOLDER.notificationsLabel.text = subjectList[position].notifications.toString()
        VIEW_HOLDER.timeLabel.text = subjectList[position].startTime
        VIEW_HOLDER.dayLabel.text = subjectList[position].days.joinToString("  ")


        if (dayOrTime == "day") {
            VIEW_HOLDER.timeLabel.visibility = View.INVISIBLE
            VIEW_HOLDER.dayLabel.visibility = View.VISIBLE
        } else {
            VIEW_HOLDER.timeLabel.visibility = View.VISIBLE
            VIEW_HOLDER.dayLabel.visibility = View.INVISIBLE
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