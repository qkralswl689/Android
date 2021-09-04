package skmagic.mes.pda.View.Common;

public class PDA_WM_LISTVIEWITEM {

    private String _workorder;
    private String _material;
    private String _productdef;
    private String _qty;

    public void setWorkOrder(String workorder) {
        _workorder = workorder;
    }

    public void setMaterial(String material) {
        _material = material;
    }

    public void setProductdef(String productdef) {
        _productdef = productdef;
    }

    public void setQty(String qty) {
        _qty = qty;
    }


    public String getWorkOrder() {
        return this._workorder;
    }

    public String getMaterial() {
        return this._material;
    }


    public String getProductdef() {
        return this._productdef;
    }

    public String getQty() {
        return this._qty;
    }


}
