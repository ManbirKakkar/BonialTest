package io.bonial.test.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.google.gson.Gson
import io.bonial.test.R
import io.bonial.test.data.model.ContentObj
import io.bonial.test.data.model.Contents
import io.bonial.test.databinding.ItemLayoutBinding
import io.bonial.test.ui.main.adapter.BrochureAdapter.DataViewHolder
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class BrochureAdapter(private val context: Context,private val contentsData: ArrayList<Contents>) : RecyclerView.Adapter<DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contentsData.size
    }

    inner class DataViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(contents: Contents) {
            itemView.apply {
                /**
                 * Content is received both as Array and Object with same key name
                 * converted it to json and then re-converted it to the desiredObject
                 * since it was received as Any
                 */
                val content = Gson().fromJson(Gson().toJson(contents.content), ContentObj::class.java)

                /**
                 * Load Retailer Name
                 */
                content.retailer.let {
                    binding.textView.text = it?.name ?: ""
                }

                /**
                 * Load Image
                 */
                Glide.with(context)
                    .load(content.brochureImage)
                    .error(Glide
                        .with(context)
                        .load("https://jdih.anri.go.id/admin/uploads/nopreview.png"))
                    .apply(
                        RequestOptions()
                            .placeholder(R.mipmap.ic_launcher_round)
                            .centerCrop()
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .priority(Priority.HIGH)
                    )
                    .into(binding.imageView);

            }
        }
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(contentsData[position])
    }

    fun addUsers(contentsData: List<Contents>) {
        this.contentsData.apply {
            clear()
            addAll(contentsData)
        }
    }

    fun getItemContentType(position: Int): String? {
        return contentsData[position].contentType
    }

}


