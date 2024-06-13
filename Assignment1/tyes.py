def sort1(lst):
    if len(lst) == 1:
        new_list = lst
    else:
        # new_list = [None for _ in range(len(lst))]
        new_list = []   # Empty list
        merge_sort1(lst, new_list, 0, len(lst) - 1)
    return new_list


def merge_sort1(lst, new_list, left, right):
    if int(left) < int(right):
        center = int((left + right)) // 2
        merge_sort1(lst, new_list, left, center)
        merge_sort1(lst, new_list, center + 1, right)
        merge1(lst, new_list, left, int(center) + 1, right)


# def merge1(lst, new_list, left_pos, right_pos, right_end):
#     left_end = int(right_pos) - 1
#     tmp_pos = int(left_pos)
#     num_elements = int(right_end) - int(left_pos) + 1
#     while (left_pos <= left_end) and (right_pos <= right_end):
#         if lst[left_pos][0] < lst[right_pos][0]:
#             new_list[tmp_pos] = lst[left_pos]
#             tmp_pos += 1
#             left_pos = left_pos + 1
#         elif lst[left_pos][0] == lst[right_pos][0]:
#             if lst[left_pos][1] < lst[right_pos][1]:
#                 new_list[tmp_pos] = lst[left_pos]
#                 tmp_pos += 1
#                 left_pos = left_pos + 1
#             else:
#                 new_list[tmp_pos] = lst[right_pos]
#                 tmp_pos += 1
#                 right_pos = right_pos + 1
#         else:
#             new_list[tmp_pos] = lst[right_pos]
#             tmp_pos += 1
#             right_pos = right_pos + 1
#     while left_pos <= left_end:
#         new_list[tmp_pos] = lst[left_pos]
#         tmp_pos += 1
#         left_pos = left_pos + 1
#     while right_pos <= right_end:
#         new_list[tmp_pos] = lst[right_pos]
#         tmp_pos += 1
#         right_pos = right_pos + 1
#     i = 0
#     while i < num_elements:
#         lst[right_end] = new_list[right_end]
#         right_end -= 1
#         i += 1
def merge1(lst, new_list, left_pos, right_pos, right_end):
    left_end = int(right_pos) - 1
    # tmp_pos = int(left_pos)
    num_elements = int(right_end) - int(left_pos) + 1
    while (left_pos <= left_end) and (right_pos <= right_end):
        if lst[left_pos][0] < lst[right_pos][0]:
            new_list.append(lst[left_pos])
            left_pos = left_pos + 1
        elif lst[left_pos][0] == lst[right_pos][0]:
            if lst[left_pos][1] < lst[right_pos][1]:
                new_list.append(lst[left_pos])
                left_pos = left_pos + 1
            else:
                new_list.append(lst[right_pos])
                right_pos = right_pos + 1
        else:
            new_list.append(lst[right_pos])
            right_pos = right_pos + 1
    while left_pos <= left_end:
        new_list.append(lst[left_pos])
        left_pos = left_pos + 1
    while right_pos <= right_end:
        new_list.append(lst[right_pos])
        right_pos = right_pos + 1
    
    print(new_list)     # check

    i = 0
    while i < num_elements:
        lst[right_end] = new_list[right_end]
        right_end -= 1
        i += 1
    print(lst)
        


def sort2(lst):
    if len(lst) == 1:
        new_list = lst
    else:
        new_list = [None for _ in range(len(lst))]
        merge_sort2(lst, new_list, 0, len(lst) - 1)
    return new_list


def merge_sort2(lst, new_list, left, right):
    if int(left) < int(right):
        center = int((left + right)) // 2
        merge_sort2(lst, new_list, left, center)
        merge_sort2(lst, new_list, center + 1, right)
        merge2(lst, new_list, left, int(center) + 1, right)


def merge2(lst, new_list, left_pos, right_pos, right_end):
    left_end = int(right_pos) - 1
    tmp_pos = int(left_pos)
    num_elements = int(right_end) - int(left_pos) + 1
    while int(left_pos) <= left_end and int(right_pos) <= int(right_end):
        if lst[int(left_pos)][0] > lst[int(right_pos)][0]:
            new_list[tmp_pos] = lst[int(left_pos)]
            tmp_pos += 1
            left_pos = int(left_pos) + 1
        elif lst[int(left_pos)][0] == lst[int(right_pos)][0]:
            if lst[int(left_pos)][1] < lst[int(right_pos)][1]:
                new_list[tmp_pos] = lst[int(left_pos)]
                tmp_pos += 1
                left_pos = int(left_pos) + 1
            else:
                new_list[tmp_pos] = lst[int(right_pos)]
                tmp_pos += 1
                right_pos = int(right_pos) + 1
        else:
            new_list[tmp_pos] = lst[int(right_pos)]
            tmp_pos += 1
            right_pos = int(right_pos) + 1
    while int(left_pos) <= left_end:
        new_list[tmp_pos] = lst[int(left_pos)]
        tmp_pos += 1
        left_pos = int(left_pos) + 1
    while int(right_pos) <= int(right_end):
        new_list[tmp_pos] = lst[int(right_pos)]
        tmp_pos += 1
        right_pos = int(right_pos) + 1
    i = 0
    while i < num_elements:
        lst[int(right_end)] = new_list[int(right_end)]
        right_end -= 1
        i += 1


def sort3(lst):
    if len(lst) == 1:
        new_list = lst
    else:
        new_list = [None for _ in range(len(lst))]
        merge_sort3(lst, new_list, 0, len(lst) - 1)
    return new_list


def merge_sort3(lst, new_list, left, right):
    if int(left) < int(right):
        center = int((left + right)) // 2
        merge_sort3(lst, new_list, left, center)
        merge_sort3(lst, new_list, center + 1, right)
        merge3(lst, new_list, left, int(center) + 1, right)


def merge3(lst, new_list, left_pos, right_pos, right_end):
    left_end = int(right_pos) - 1
    tmp_pos = int(left_pos)
    num_elements = int(right_end) - int(left_pos) + 1
    while int(left_pos) <= left_end and int(right_pos) <= int(right_end):
        if lst[int(left_pos)][0] < lst[int(right_pos)][0]:
            new_list[tmp_pos] = lst[int(left_pos)]
            tmp_pos += 1
            left_pos = int(left_pos) + 1
        elif lst[int(left_pos)][0] == lst[int(right_pos)][0]:
            if lst[int(left_pos)][1] > lst[int(right_pos)][1]:
                new_list[tmp_pos] = lst[int(left_pos)]
                tmp_pos += 1
                left_pos = int(left_pos) + 1
            else:
                new_list[tmp_pos] = lst[int(right_pos)]
                tmp_pos += 1
                right_pos = int(right_pos) + 1
        else:
            new_list[tmp_pos] = lst[int(right_pos)]
            tmp_pos += 1
            right_pos = int(right_pos) + 1
    while int(left_pos) <= left_end:
        new_list[tmp_pos] = lst[int(left_pos)]
        tmp_pos += 1
        left_pos = int(left_pos) + 1
    while int(right_pos) <= int(right_end):
        new_list[tmp_pos] = lst[int(right_pos)]
        tmp_pos += 1
        right_pos = int(right_pos) + 1
    i = 0
    while i < num_elements:
        lst[int(right_end)] = new_list[int(right_end)]
        right_end -= 1
        i += 1


def sort4(lst):
    if len(lst) == 1:
        new_list = lst
    else:
        new_list = [None for _ in range(len(lst))]
        merge_sort4(lst, new_list, 0, len(lst) - 1)
    return new_list


def merge_sort4(lst, new_list, left, right):
    if left < right:
        center = (left + right) // 2
        merge_sort4(lst, new_list, left, center)
        merge_sort4(lst, new_list, center + 1, right)
        merge4(lst, new_list, left, int(center) + 1, right)





def merge4(lst, new_list, left_pos, right_pos, right_end):
    left_end = int(right_pos) - 1
    tmp_pos = int(left_pos)
    num_elements = int(right_end) - int(left_pos) + 1
    while (left_pos <= left_end) and (right_pos <= right_end):
        if lst[left_pos][0] > lst[right_pos][0]:
            new_list[tmp_pos] = lst[left_pos]
            tmp_pos += 1
            left_pos = left_pos + 1
        elif lst[left_pos][0] == lst[right_pos][0]:
            if lst[left_pos][1] > lst[right_pos][1]:
                new_list[tmp_pos] = lst[left_pos]
                tmp_pos += 1
                left_pos = left_pos + 1
            else:
                new_list[tmp_pos] = lst[int(right_pos)]
                tmp_pos += 1
                right_pos = int(right_pos) + 1
        else:
            new_list[tmp_pos] = lst[int(right_pos)]
            tmp_pos += 1
            right_pos = int(right_pos) + 1
    while int(left_pos) <= left_end:
        new_list[tmp_pos] = lst[int(left_pos)]
        tmp_pos += 1
        left_pos = int(left_pos) + 1
    while int(right_pos) <= int(right_end):
        new_list[tmp_pos] = lst[int(right_pos)]
        tmp_pos += 1
        right_pos = int(right_pos) + 1
    i = 0
    while i < num_elements:
        lst[int(right_end)] = new_list[int(right_end)]
        right_end -= 1
        i += 1


def output(l):
    for i in l:
        print(i[0], i[1])
    print("")

n_tests = input()
order = 0
result = []
while order < int(n_tests):
    order += 1
    n, k, i_d = input().split()
    n = int(n)
    k = int(k)
    i_d = int(i_d)
    sort_list = [[int(i) // k, int(i) % k] for i in input().split()]
    if i_d == 1:
        output((sort1(sort_list)))
    elif i_d == 2:
        output(sort2(sort_list))
    elif i_d == 3:
        output(sort3(sort_list))
    elif i_d == 4:
        output(sort4(sort_list))
