package za.co.za.nharire.divisi.asset.service;


import za.co.za.nharire.divisi.asset.model.Asset;

public interface AssetService<T extends Asset> {

    T create(T asset, Long farmerId);

    T findById(Long id);

    Iterable<T> findAll();

    T update(T asset);

    void delete(Long id);
}
