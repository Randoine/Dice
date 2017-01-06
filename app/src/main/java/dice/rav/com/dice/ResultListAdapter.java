package dice.rav.com.dice;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rav on 2017-01-06.
 */

public class ResultListAdapter extends RecyclerView.Adapter<ResultListAdapter.ResultViewHolder>{
    private List<Result> mResults;

    public ResultListAdapter(List<Result> mResults) {
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
        holder.mResults.setText(result.getResultArray().toString());
    }

    @Override
    public int getItemCount() {
        return mResults.size();

    }

    public class ResultViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.result)
        TextView mResults;

        public ResultViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}
