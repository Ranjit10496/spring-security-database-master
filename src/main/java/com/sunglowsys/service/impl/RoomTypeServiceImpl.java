package com.sunglowsys.service.impl;

import com.sunglowsys.domain.RoomType;
import com.sunglowsys.repository.RoomTypeRepository;
import com.sunglowsys.service.RoomTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {
    private final RoomTypeRepository roomTypeRepository;

    public RoomTypeServiceImpl(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }

    @Override
    public RoomType save(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    @Override
    public RoomType update(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    @Override
    public Page<RoomType> getAll(Pageable pageable) {
        return roomTypeRepository.findAll(pageable);
    }

    @Override
    public Optional<RoomType> getOne(Long id) {
        return roomTypeRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        roomTypeRepository.deleteById(id);
    }

    @Override
    public List<RoomType> getAll() {
        return roomTypeRepository.findAll();
    }
}
