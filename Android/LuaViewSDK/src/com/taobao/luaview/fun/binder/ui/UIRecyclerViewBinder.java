package com.taobao.luaview.fun.binder.ui;

import com.taobao.luaview.fun.base.BaseFunctionBinder;
import com.taobao.luaview.fun.base.BaseVarArgUICreator;
import com.taobao.luaview.fun.mapper.list.UIRecyclerViewMethodMapper;
import com.taobao.luaview.view.LVRecyclerView;
import com.taobao.luaview.view.interfaces.ILVView;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.LibFunction;

/**
 * RecyclerView for LuaView
 *
 * @author song
 * @date 15/8/20
 */
public class UIRecyclerViewBinder extends BaseFunctionBinder {

    public UIRecyclerViewBinder() {
        super("CollectionView");
    }

    @Override
    public Class<? extends LibFunction> getMapperClass() {
        return UIRecyclerViewMethodMapper.class;
    }

    @Override
    public LuaValue createCreator(LuaValue env, LuaValue metaTable) {
        return new BaseVarArgUICreator(env.checkglobals(), metaTable) {
            @Override
            public ILVView createView(Globals globals, LuaValue metaTable, Varargs varargs) {
//                return new LVRecyclerView(globals, metaTable, varargs, null);
                return LVRecyclerView.createVerticalView(globals, metaTable, varargs, null);
            }
        };
    }
}