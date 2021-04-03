package android.learning

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*

// For the RecyclerView, we need to complete an adapter to make it work, as it's custom work
// This holds data relating to state and managing items
class TodoAdapter(
    var todos: List<Todo>
): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    // Must always have an inner class to hold the todos or whatever
    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    // Must always implement the three methods
    // Inflate the view and return it inside the viewholder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        // Don't attach items to root in recyclerview to prevent crash
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    // Bind data to items
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        // for each item in the holder, apply the data from the todo list
        holder.itemView.apply {
            tvTitle.text = todos[position].title
            cbDone.isChecked = todos[position].isChecked
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}