package com.asfoundation.wallet.permissions.manage.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.asf.wallet.R
import com.jakewharton.rxrelay2.BehaviorRelay

class PermissionsListAdapter(
    private val permissions: MutableList<ApplicationPermissionViewData>,
    private val permissionClick: BehaviorRelay<ApplicationPermissionViewData>) :
    RecyclerView.Adapter<PermissionViewHolder>() {


  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PermissionViewHolder {
    return PermissionViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.item_permission_application, parent, false), permissionClick)
  }

  override fun getItemCount(): Int {
    return permissions.size
  }

  override fun onBindViewHolder(holder: PermissionViewHolder, position: Int) {
    holder.bindPermission(permissions[position])
  }

  fun setPermissions(permissions: List<ApplicationPermissionViewData>) {
    this.permissions.clear()
    this.permissions.addAll(permissions)
    notifyDataSetChanged()
  }
}
