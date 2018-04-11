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

public class FragmentSteps extends Fragment {

    View rootView;
    ExpandableListView lv;
    private String[] groups;
    private String[][] children;

    private ExpandableListView expandableList;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        groups = new String[] { getString(R.string.step_name_1),getString(R.string.step_name_2),getString(R.string.step_name_3),getString(R.string.step_name_4),
                getString(R.string.step_name_5), getString(R.string.step_name_6)};

        children = new String [][] {
                {getString(R.string.step_content_1)},
                {getString(R.string.step_content_2_1),getString(R.string.step_content_2_2),getString(R.string.step_content_2_3)},
                {getString(R.string.step_content_3_1),getString(R.string.step_content_3_2),getString(R.string.step_content_3_3),getString(R.string.step_content_3_4),
                        getString(R.string.step_content_3_5),getString(R.string.step_content_3_6),getString(R.string.step_content_3_7),getString(R.string.step_content_3_8),
                        getString(R.string.step_content_3_9),getString(R.string.step_content_3_10)},
                {getString(R.string.step_content_4_1),getString(R.string.step_content_4_2),getString(R.string.step_content_4_3),getString(R.string.step_content_4_4),
                        getString(R.string.step_content_4_5),getString(R.string.step_content_4_6),getString(R.string.step_content_4_7),getString(R.string.step_content_4_8)},
                {getString(R.string.step_content_5_1),getString(R.string.step_content_5_2),getString(R.string.step_content_5_3),getString(R.string.step_content_5_4),
                        getString(R.string.step_content_5_5),getString(R.string.step_content_5_6),getString(R.string.step_content_5_7),getString(R.string.step_content_5_8)},
                {getString(R.string.step_content_6_1),getString(R.string.step_content_6_2)}
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
                if(children[groupPosition][childPosition].toString() == getString(R.string.step_content_2_2)) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://urfu.ru/ru/applicant/docs-abiturient/programs/"));
                    startActivity(browserIntent);
                }
                if(children[groupPosition][childPosition].toString() == getString(R.string.step_content_3_2)) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://urfu.ru/fileadmin/user_upload/urfu.ru/documents/applicant/2018/postuplenie-vo/Pravila_priema_po_programmam_bakalavriata_i_specialiteta_2018.pdf"));
                    startActivity(browserIntent);
                }
                if(children[groupPosition][childPosition].toString() == getString(R.string.step_content_3_4)) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://urfu.ru/fileadmin/user_upload/urfu.ru/documents/applicant/2018/postuplenie-vo/Informacija_o_srokakh_provedenija_priema_na_mesta_v_ramkakh_KCP.pdf"));
                    startActivity(browserIntent);
                }
                if(children[groupPosition][childPosition].toString() == getString(R.string.step_content_3_6)) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://urfu.ru/fileadmin/user_upload/urfu.ru/documents/applicant/2018/postuplenie-vo/Plan_priema_2018_po_napravlenijam_bakalavriata_i_specialiteta__bjudzhet__kontrakt_.pdf"));
                    startActivity(browserIntent);
                }
                if(children[groupPosition][childPosition].toString() == getString(R.string.step_content_3_8)) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://urfu.ru/fileadmin/user_upload/urfu.ru/documents/applicant/2018/postuplenie-vo/Lgoty_dlja_pobeditelei_i_prizerov_olimpiad.pdf"));
                    startActivity(browserIntent);
                }
                if(children[groupPosition][childPosition].toString() == getString(R.string.step_content_3_10)) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://urfu.ru/fileadmin/user_upload/urfu.ru/documents/applicant/2018/postuplenie-vo/Informacija_o_predostavljaemykh_postupajushchim_osobykh_prav_i_preimushchestv.pdf"));
                    startActivity(browserIntent);
                }
                if(children[groupPosition][childPosition].toString() == getString(R.string.step_content_4_2)) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://urfu.ru/fileadmin/user_upload/urfu.ru/documents/applicant/2018/postuplenie-vo/Perechen_vstupitelnykh_ispytanii_s_ukazaniem_minimalnykh_ballov.pdf"));
                    startActivity(browserIntent);
                }
                if(children[groupPosition][childPosition].toString() == getString(R.string.step_content_4_4)) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://urfu.ru/ru/school/olympiad/"));
                    startActivity(browserIntent);
                }
                if(children[groupPosition][childPosition].toString() == getString(R.string.step_content_4_6)) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://urfu.ru/fileadmin/user_upload/urfu.ru/documents/applicant/2018/postuplenie-vo/Informacija_o_porjadke_ucheta_individualnykh_dostizhenii.pdf"));
                    startActivity(browserIntent);
                }
                if(children[groupPosition][childPosition].toString() == getString(R.string.step_content_4_8)) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://urfu.ru/ru/applicant/docs-abiturient/"));
                    startActivity(browserIntent);
                }
                if(children[groupPosition][childPosition].toString() == getString(R.string.step_content_5_2)) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://urfu.ru/fileadmin/user_upload/urfu.ru/documents/applicant/2018/postuplenie-vo/Informacija_o_srokakh_provedenija_priema_na_mesta_v_ramkakh_KCP.pdf"));
                    startActivity(browserIntent);
                }
                if(children[groupPosition][childPosition].toString() == getString(R.string.step_content_5_4)) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://urfu.ru/fileadmin/user_upload/urfu.ru/documents/applicant/2018/postuplenie-vo/Informacija_o_pochtovykh_adresakh_dlja_napravlenija_dokumentov__neobkhodimykh_dlja_postuplenija.pdf"));
                    startActivity(browserIntent);
                }
                if(children[groupPosition][childPosition].toString() == getString(R.string.step_content_5_6)) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://urfu.ru/fileadmin/user_upload/urfu.ru/documents/applicant/2018/postuplenie-vo/Informacija_o_mestakh_priema_dokumentov__neobkhodimykh_dlja_postuplenija.pdf"));
                    startActivity(browserIntent);
                }
                if(children[groupPosition][childPosition].toString() == getString(R.string.step_content_5_8)) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://urfu.ru/fileadmin/user_upload/urfu.ru/documents/applicant/2018/postuplenie-vo/Informacija_o_vozmozhnosti_podachi_dokumentov_v_ehlektronnoi_forme.pdf"));
                    startActivity(browserIntent);
                }
                if(children[groupPosition][childPosition].toString() == getString(R.string.step_content_6_2)) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://urfu.ru/ru/applicant/"));
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
                convertView = inf.inflate(R.layout.list_group_steps, parent, false);
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
