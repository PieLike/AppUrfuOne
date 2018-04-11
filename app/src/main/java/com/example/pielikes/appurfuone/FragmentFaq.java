package com.example.pielikes.appurfuone;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListAdapter;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;
import android.widget.ExpandableListView.OnChildClickListener;


import static com.example.pielikes.appurfuone.R.id.parent;

public class FragmentFaq extends Fragment {

    View rootView;
    ExpandableListView lv;
    private String[] groups;
    private String[][] children;

    private ExpandableListView expandableList;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        groups = new String[] { getString(R.string.faq_Quest_1),getString(R.string.faq_Quest_2),getString(R.string.faq_Quest_3),getString(R.string.faq_Quest_4),
                getString(R.string.faq_Quest_5), getString(R.string.faq_Quest_6), getString(R.string.faq_Quest_7), getString(R.string.faq_Quest_8),
                getString(R.string.faq_Quest_9), getString(R.string.faq_Quest_10), getString(R.string.faq_Quest_11), getString(R.string.faq_Quest_12),
                getString(R.string.faq_Quest_13), getString(R.string.faq_Quest_14), getString(R.string.faq_Quest_15), getString(R.string.faq_Quest_16),
                getString(R.string.faq_Quest_17), getString(R.string.faq_Quest_18), getString(R.string.faq_Quest_19), getString(R.string.faq_Quest_20),
                getString(R.string.faq_Quest_21)};

        children = new String [][] {
                {getString(R.string.faq_Answer_1)},
                {getString(R.string.faq_Answer_2)},
                {getString(R.string.faq_Answer_3)},
                {getString(R.string.faq_Answer_4),getString(R.string.faq_Answer_4_site1)},
                {getString(R.string.faq_Answer_5)},
                {getString(R.string.faq_Answer_6)},
                {getString(R.string.faq_Answer_7),getString(R.string.faq_Answer_7_site1)},
                {getString(R.string.faq_Answer_8)},
                {getString(R.string.faq_Answer_9),getString(R.string.faq_Answer_9_site1)},
                {getString(R.string.faq_Answer_10)},
                {getString(R.string.faq_Answer_11)},
                {getString(R.string.faq_Answer_12)},
                {getString(R.string.faq_Answer_13),getString(R.string.faq_Answer_13_site1)},
                {getString(R.string.faq_Answer_14)},
                {getString(R.string.faq_Answer_15)},
                {getString(R.string.faq_Answer_16)},
                {getString(R.string.faq_Answer_17)},
                {getString(R.string.faq_Answer_18)},
                {getString(R.string.faq_Answer_19)},
                {getString(R.string.faq_Answer_20),getString(R.string.faq_Answer_20_site1)},
                {getString(R.string.faq_Answer_21)}
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        return inflater.inflate(R.layout.fragment_faq, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lv = (ExpandableListView) view.findViewById(R.id.expListView);
        lv.setAdapter(new ExpandableListAdapter(groups, children));
        lv.setGroupIndicator(null);
        ExpandableListView expandableListView = (ExpandableListView)  view.findViewById(R.id.expListView);

        expandableListView.setOnChildClickListener(new OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandablelistview,
                                        View clickedView, int groupPosition, int childPosition, long childId) {
                if(children[groupPosition][childPosition].toString() == getString(R.string.faq_Answer_4_site1)) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://urfu.ru/ru/applicant/docs-abiturient/individual-achievements/"));
                    startActivity(browserIntent);
                }
                if(children[groupPosition][childPosition].toString() == getString(R.string.faq_Answer_7_site1)) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://urfu.ru/ru/applicant/docs-abiturient/"));
                    startActivity(browserIntent);
                }
                if(children[groupPosition][childPosition].toString() == getString(R.string.faq_Answer_9_site1)) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://urfu.ru/fileadmin/user_upload/urfu.ru/documents/applicant/2018/postuplenie-vo/Plan_priema_2018_po_napravlenijam_bakalavriata_i_specialiteta__bjudzhet__kontrakt_.pdf"));
                    startActivity(browserIntent);
                }
                if(children[groupPosition][childPosition].toString() == getString(R.string.faq_Answer_13_site1)) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://priem.urfu.ru/ege"));
                    startActivity(browserIntent);
                }
                if(children[groupPosition][childPosition].toString() == getString(R.string.faq_Answer_20_site1)) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://urfu.ru/fileadmin/user_upload/urfu.ru/documents/applicant/2018/postuplenie-vo/Lgoty_dlja_pobeditelei_i_prizerov_olimpiad.pdf"));
                    startActivity(browserIntent);
                }
                return false;
            }
        });

    }
    public class ExpandableListAdapter extends BaseExpandableListAdapter {

        private final LayoutInflater inf;
        private String[] groups;
        private String[][] children;

        public ExpandableListAdapter(String[] groups, String[][] children) {
            this.groups = groups;
            this.children = children;
            inf = LayoutInflater.from(getActivity());
        }

        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return children[groupPosition].length;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groups[groupPosition];
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return children[groupPosition][childPosition];
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

            ViewHolder holder;
            if (convertView == null) {
                convertView = inf.inflate(R.layout.list_item, parent, false);
                holder = new ViewHolder();
                holder.text = (TextView) convertView.findViewById(R.id.textView6);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.text.setText(getChild(groupPosition, childPosition).toString());

            return convertView;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if (convertView == null) {
                convertView = inf.inflate(R.layout.list_group, parent, false);

                holder = new ViewHolder();
                holder.text = (TextView) convertView.findViewById(R.id.lblListHeader);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.text.setText(getGroup(groupPosition).toString());

            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {

            return true;
        }

        private class ViewHolder {
            TextView text;
        }
    }
}
