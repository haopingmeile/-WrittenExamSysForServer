package com.haoping.wirttenexamination.clientdate;

public class MyClientPoolableData extends MyClientData implements org.apache.commons.pool.PoolableObjectFactory {

	@Override
	public void activateObject(Object arg0) throws Exception {
	}

	@Override
	public void destroyObject(Object obj) throws Exception {
		if (obj == null)
			return;
		passivateObject(obj);
		obj = null;

	}

	@Override
	public Object makeObject() throws Exception {
		return new MyClientPoolableData();
	}

	@Override
	public void passivateObject(Object obj) throws Exception {
		MyClientPoolableData pd = (MyClientPoolableData) obj;
		pd.setUsername(null);
		pd.setUserId(null);
//		pd.setDeviceIds(null);
//		pd.setPreparedStatement(null);
//		pd.setResultSet(null);
//		pd.setEnable(false);
	}

	@Override
	public boolean validateObject(Object obj) {
		if (obj == null)
			return false;
		else
			return true;
	}

}