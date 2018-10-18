package com.example.work_gadnuuk.spisok;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class SpisokListFragment extends Fragment {

    private RecyclerView mPoleRecyclerView;
    private SpisokAdapter mAdapter;
    //private Button mButton;
    //private static final String DIALOG_ADD = "DialogAdd";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spisok_list, container, false);
        mPoleRecyclerView = (RecyclerView) view.findViewById(R.id.spisok_recycler_view);
        mPoleRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        /**mButton = (Button) view.findViewById(R.id.addButton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                PickerFragment dialog = new PickerFragment();
                dialog.show(manager, DIALOG_ADD);
            }
        });*/
        return view;
    }

    /**public void ShowDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();

            }
        })
                .setNegativeButton("Reveit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        builder.create().show();
    }*/

    private void updateUI() {
        PoleLab poleLab = PoleLab.get(getActivity());
        List<Pole> poles = poleLab.getPoles();
        mAdapter = new SpisokAdapter(poles);
        mPoleRecyclerView.setAdapter(mAdapter);
    }

    private class SpisokHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private TextView mTitleTextView;
        private Pole mPole;

        public SpisokHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_pole, parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.pole_title);
        }

        public void bind(Pole pole) {
            mPole = pole;
            mTitleTextView.setText(mPole.getTitle());
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(),
                    mPole.getTitle() + "clicked", Toast.LENGTH_SHORT).show();

        }
    }

    private class SpisokAdapter extends RecyclerView.Adapter<SpisokHolder> {

        private List<Pole> mPoles;

        public SpisokAdapter(List<Pole> poles) {
            mPoles = poles;
        }

        @NonNull
        @Override
        public SpisokHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new SpisokHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull SpisokHolder holder, int position) {
            Pole pole = mPoles.get(position);
            holder.bind(pole);

        }

        @Override
        public int getItemCount() {
            return mPoles.size();
        }
    }
}
