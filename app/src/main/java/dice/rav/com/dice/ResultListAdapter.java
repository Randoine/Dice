package dice.rav.com.dice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ResultListAdapter extends RecyclerView.Adapter<ResultListAdapter.ResultViewHolder>{
    private ArrayList<Result> mResults;
    private Context context;

    public ResultListAdapter(ArrayList<Result> mResults, Context context) {
        this.mResults = mResults;
        this.context = context;
    }

    public ArrayList<Result> getmResults() {
        return mResults;
    }

    public void setmResults(ArrayList<Result> mResults) {
        this.mResults = mResults;
    }

    @Override
    public ResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View rowView = inflater.inflate(R.layout.list_item_result, parent, false);
        return new ResultViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(ResultViewHolder holder, int position) {
        //Pobranie elementu danych na pozycji position
        Result result = mResults.get(position);
        //Uzupełnienie wodoku na podstawie pobranego obiektu
        holder.mResults.setText(Arrays.toString(result.getResultArray()));

    }

    @Override
    public int getItemCount() {
        return mResults.size();

    }

    public void delete (int position){
        mResults.remove(position);
        notifyItemRemoved(position);
    }

    public class ResultViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.result)
        TextView mResults;

        @BindView(R.id.delete_button)
        ImageButton mDeleteButton;

        public ResultViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.delete_button)
        void onItemClick() {
            delete(getAdapterPosition());

            }
        }
    }


